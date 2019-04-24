package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindPage(){
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
         System.out.println(all);
    }

    @Test
    public void testUpdate(){
        Optional<CmsPage> optional = cmsPageRepository.findById("5b17a34211fe5e2ee8c116c9");
        if (optional.isPresent()){
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("王者");
            cmsPageRepository.save(cmsPage);
        }
    }

    @Test
    public void findByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("297e7c7c62b8aa9d0162b8ab13910000.html");
        System.out.println(cmsPage);
    }

    @Test
    public void test01(){
        int a = 10 ;
        System.out.println(a);
    }

}
