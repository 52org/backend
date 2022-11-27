package com.letter.plant.application.letter.api;

import com.letter.plant.application.letter.dto.LetterDetailDto;
import com.letter.plant.application.letter.dto.LetterDto;
import com.letter.plant.application.letter.dto.LetterWrapperDto;
import com.letter.plant.application.letter.service.LetterService;
import com.letter.plant.core.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LetterController {

    private final LetterService letterService;

    @PostMapping("/letter/send")
    private ApiResponse letterSend(LetterDto letterDto) {
        letterService.makeLetter(letterDto);

        return ApiResponse.noContent();
    }

    @GetMapping("/letter/detail/{letterId}")
    private ApiResponse letterDetail(@PathVariable String letterId) {
        LetterDetailDto letter = letterService.getLetter(letterId);

        return ApiResponse.success(letter);
    }

    @GetMapping("/letter/list/{uuid}")
    private ApiResponse letterList(@PathVariable String uuid) {
        List<LetterWrapperDto> letters = letterService.getLetterList(uuid);

        return ApiResponse.success(letters);
    }
}