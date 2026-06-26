package org.scoula.controller;

import lombok.RequiredArgsConstructor;
import org.scoula.domain.AttachmentVO;
import org.scoula.domain.BoardVO;
import org.scoula.mapper.AttachmentMapper;
import org.scoula.service.BoardService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final AttachmentMapper attachmentMapper;

    @GetMapping("/register")
    public String registerForm() {
        return "board/register";
    }

    @PostMapping("/register")
    public String register(BoardVO board,
                           @RequestParam("files") MultipartFile[] files)
            throws Exception {

        boardService.register(board, files);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute(
                "list",
                boardService.getList()
        );

        return "board/list";
    }

    @GetMapping("/read/{boardId}")
    public String read(@PathVariable Long boardId,
                       Model model) {

        model.addAttribute(
                "board",
                boardService.get(boardId)
        );

        return "board/read";
    }

    @GetMapping("/download/{attachId}")
    public ResponseEntity<ByteArrayResource> download(
            @PathVariable Long attachId
    ) {

        AttachmentVO file =
                attachmentMapper.get(attachId);

        ByteArrayResource resource =
                new ByteArrayResource(
                        file.getFileData()
                );

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" +
                                file.getFileName() +
                                "\""
                )
                .contentLength(
                        file.getFileSize()
                )
                .body(resource);
    }
}