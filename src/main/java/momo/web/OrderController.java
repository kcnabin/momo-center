package momo.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import momo.MomoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("momoOrder")
public class OrderController {
    @GetMapping("/current")
    public String orderForm() {
        return "orderForm.html";
    }

    @PostMapping
    public String processMomo(@Valid MomoOrder momoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm.html";
        }

        log.info("Order submitted: {}", momoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
