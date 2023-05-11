package com.springbootwebservice.web;

import com.springbootwebservice.config.auth.LoginUser;
import com.springbootwebservice.config.auth.dto.SessionUser;
import com.springbootwebservice.service.posts.PostService;
import com.springbootwebservice.web.dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/form")
    public String postsSave() {
        return "postForm";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostResponse postResponse = postService.findById(id);
        model.addAttribute("post", postResponse);

        return "postUpdate";
    }
}
