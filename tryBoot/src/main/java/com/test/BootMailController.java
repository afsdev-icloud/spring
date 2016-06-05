package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/BootMail")
public class BootMailController {

    @Autowired
    private MailSender sender;

	@RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("message", "メールの宛先、件名、本文を入力してください.");
        return "mail";
    }

	@RequestMapping(method = RequestMethod.POST)
    public String sendMail(@RequestParam("to") String to,
    		@RequestParam("subject") String subject,
    		@RequestParam("body") String body, Model model) {

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("xxxx@artifacture.jp");
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);

        this.sender.send(msg);

        model.addAttribute("message", " 送信完了！");
        return "mail";
    }

}
