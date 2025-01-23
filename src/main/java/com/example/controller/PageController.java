package com.example.controller;

import com.example.controller.dto.PageDto;
import com.example.controller.dto.PageListDto;
import com.example.controller.form.AddPageForm;
import com.example.controller.form.EditPageForm;
import com.example.entity.Page;
import com.example.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @GetMapping(value = "/pages/list")
    public String list(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null && !search.isEmpty()) {
            model.addAttribute("pages", PageListDto.from(pageService.searchPages(search)));
        } else {
            model.addAttribute("pages", PageListDto.from(pageService.getPages()));
        }
        return "list";
    }

    @GetMapping("/pages/add")
    public String add() {
        return "add";
    }

    @PostMapping("/pages/add")
    public String addOk(AddPageForm form,
                        @RequestParam MultipartFile image,
                        HttpServletRequest request) {
        pageService.addPage(form, image, request);
        return "redirect:/pages/list";
    }

    @GetMapping("/pages/{id}")
    public String view(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("page", PageDto.from(pageService.getPage(id)));
        return "view";
    }

    @GetMapping("/pages/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Page page = pageService.getPage(id);
        EditPageForm form = EditPageForm.from(page);
        model.addAttribute("form", form);
        model.addAttribute("image", page.getImage());
        return "edit";
    }

    @PostMapping("/pages/edit")
    public String editOk(@ModelAttribute("form") EditPageForm form, @RequestParam MultipartFile image, HttpServletRequest request) {
        pageService.editPage(form, image, request);
        return "redirect:/pages/list";
    }

    @GetMapping("/pages/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pageService.deletePage(id);
        return "redirect:/pages/list";
    }
}
