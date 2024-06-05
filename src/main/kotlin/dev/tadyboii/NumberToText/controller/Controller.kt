package dev.tadyboii.NumberToText.controller

import dev.tadyboii.NumberToText.model.InputForm
import dev.tadyboii.NumberToText.model.ResultText
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping

@Controller
class Controller {

    @GetMapping("/converter")
    suspend fun inputForm(model: Model): String {
        model.addAttribute("inputForm", InputForm())
        model.addAttribute("result", ResultText.result)
        return "ui"
    }

    @PostMapping("/converter")
    suspend fun convertNumber(inputForm: InputForm, model: Model): String {
        ResultText.result = inputForm.number
        return "redirect:/converter"
    }
}