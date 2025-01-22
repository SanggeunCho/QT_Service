package com.example.repository;

import com.example.entity.Page;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PageRepository {
    private final SqlSession sqlSession;

    public List<Page> findAll() {
        return sqlSession.selectList("Page.findAll");
    }

    public void add(Page page) {
        sqlSession.insert("Page.add", page);
    }

    public Page findById(Integer id) {
        return sqlSession.selectOne("Page.findById", id);
    }

    public void edit(Page page) {
        sqlSession.update("Page.edit", page);
    }

    public void delete(Integer id) {
        sqlSession.delete("Page.delete", id);
    }
}
