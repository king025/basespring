package global.ntt.legstar.services;

import global.ntt.legstar.models.InquireRmRequest;
import global.ntt.legstar.models.InquireRmResponse;

public interface RmService {
    InquireRmResponse inquireRmTrailer(InquireRmRequest inquireRmRequest);
}   
