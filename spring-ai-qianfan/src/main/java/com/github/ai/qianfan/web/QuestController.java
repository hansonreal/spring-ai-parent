package com.github.ai.qianfan.web;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.core.builder.ChatBuilder;
import com.baidubce.qianfan.model.chat.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai/qianfan")
public class QuestController {


    private final Qianfan qianfan;

    public QuestController(Qianfan qianfan) {
        this.qianfan = qianfan;
    }

    @PostMapping("/quest")
    public ResponseEntity<String> quest(@RequestBody  String quest) {
        String chatContent = chat(quest);
        return ResponseEntity.ok(chatContent);
    }


    private String chat(String problem) {
        ChatBuilder builder = qianfan.chatCompletion()
                .model("ERNIE-Speed-8K");//你要使用的大模型款式，最好和我一样，其他的很有可能是收费的
        builder.addMessage("user", problem);//你的问题
        ChatResponse response = builder.execute();
        return response.getResult();
    }


}
