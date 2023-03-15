package global.ntt.legstar.controllers;

import global.ntt.legstar.models.InquireRmRequest;
import global.ntt.legstar.models.InquireRmResponse;
import global.ntt.legstar.services.RmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LegstarController {
    private final RmService rmService;

    @PostMapping("rm/inquire")
    public ResponseEntity<InquireRmResponse> inquireRmTrailer(@RequestBody InquireRmRequest inquireRmRequest) {
        return new ResponseEntity<>(rmService.inquireRmTrailer(inquireRmRequest), HttpStatus.OK);
    }
}
