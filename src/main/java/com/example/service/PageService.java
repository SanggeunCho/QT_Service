package com.example.service;

import com.example.controller.form.AddPageForm;
import com.example.controller.form.EditPageForm;
import com.example.entity.Page;
import com.example.repository.PageRepository;
import com.example.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;

    public List<Page> getPages() {
        return pageRepository.findAll();
    }

    public void addPage(AddPageForm form, MultipartFile image, HttpServletRequest request) {
        pageRepository.add(Page.builder()
                .word(form.getWord())
                .celebration(form.getCelebration())
                .summation(form.getSummation())
                .contemplation(form.getContemplation())
                .pray(form.getPray())
                .image(FileUtil.uploadFile(image, "", request))
                .build());
    }

    public Page getPage(Integer id) {
        return pageRepository.findById(id);
    }

    public void editPage(EditPageForm form, MultipartFile image, HttpServletRequest request) {
        Page page = pageRepository.findById(form.getId());
        page.setWord(form.getWord());
        page.setCelebration(form.getCelebration());
        page.setSummation(form.getSummation());
        page.setContemplation(form.getContemplation());
        page.setPray(form.getPray());
        page.setImage(FileUtil.uploadFile(image, page.getImage(), request));
        pageRepository.edit(page);
    }
    public void deletePage(Integer id) {
        pageRepository.delete(id);
    }
}
