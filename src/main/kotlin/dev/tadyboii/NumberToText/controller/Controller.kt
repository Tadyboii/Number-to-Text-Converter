package dev.tadyboii.NumberToText.controller

import dev.tadyboii.NumberToText.model.InputForm
import dev.tadyboii.NumberToText.model.ResultText
import dev.tadyboii.NumberToText.util.toText
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class Controller {

    @GetMapping("/converter")
    suspend fun inputForm(@RequestParam(required = false) number: Int?, model: Model): String {
        model.addAttribute("inputForm", InputForm(number = number))
        model.addAttribute("result", ResultText.result)
        return "ui"
    }

    @PostMapping("/converter")
    suspend fun convertNumber(inputForm: InputForm, model: Model): String {
        ResultText.result = inputForm.number?.toText()
        return "redirect:/converter?number=${inputForm.number}"
    }
}