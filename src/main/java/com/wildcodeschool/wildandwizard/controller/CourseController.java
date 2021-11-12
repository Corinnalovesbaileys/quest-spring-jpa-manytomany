package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.Course;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.CourseRepository;
import com.wildcodeschool.wildandwizard.repository.WizardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private WizardRepository wizardRepository;

    @GetMapping("/courses")
    public String getCourses(Model out) {

        out.addAttribute("courses", courseRepository.findAll());

        return "courses";
    }

    @GetMapping("/courseWizards")
    public String getCoursesWithWizards(Model out, @RequestParam("idCourse")Long idCourse) {

        Course course = courseRepository.findById(idCourse).get();
        out.addAttribute("wizards", course.getWizards());

        return "wizards";
    }
}
