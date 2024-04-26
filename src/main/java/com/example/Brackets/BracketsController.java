package com.example.Brackets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BracketsController {
    @GetMapping("/check")
    public String readfile(@RequestParam(name="filename") String fname, Model model){
        model.asMap().put("filename", fname);
        try {
            fname = "src//main//resources//files//"+fname;
            Brackets s = new Brackets();
            s.readFromFile(fname);
            model.addAttribute("brackets", s.b);
            int res = s.check();
            model.addAttribute("result", res);
            return "result";
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "check";
        }
    }
}