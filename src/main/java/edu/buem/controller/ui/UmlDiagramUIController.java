package edu.buem.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ui/v1/umlDiagram/")
@Controller
public class UmlDiagramUIController {
    @GetMapping("")
    public String showAll(Model model)
    {
        return "umlDiagram";
    }
}
