package org.scoula.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.service.ChatRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @GetMapping("/rooms")
    public String rooms(Model model) {

        model.addAttribute(
                "rooms",
                chatRoomService.getRooms()
        );

        return "chat/rooms";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam String roomName
    ) {

        chatRoomService.createRoom(roomName);

        return "redirect:/chat/rooms";
    }

    @GetMapping("/{roomId}")
    public String room(
            @PathVariable Long roomId,
            Model model
    ) {

        model.addAttribute(
                "room",
                chatRoomService.getRoom(roomId)
        );

        return "chat/room";
    }
}