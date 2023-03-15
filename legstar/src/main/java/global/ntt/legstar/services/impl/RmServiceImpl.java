package global.ntt.legstar.services.impl;

import global.ntt.legstar.exceptions.ProcessException;
import global.ntt.legstar.models.InquireRmRequest;
import global.ntt.legstar.models.InquireRmResponse;
import global.ntt.legstar.models.rm.input.Rmacctno;
import global.ntt.legstar.models.rm.input.RmacctnoFromCustCtls;
import global.ntt.legstar.services.RmService;
import global.ntt.legstar.transformers.RmRequestResponseTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RmServiceImpl implements RmService {
    private final RmRequestResponseTransformer rmRequestResponseTransformer;
    @Override
    public InquireRmResponse inquireRmTrailer(InquireRmRequest inquireRmRequest) {
        log.info("start - inquireRmTrailer");
        Rmacctno rmacctno = new Rmacctno();
        RmacctnoFromCustCtls rmacctnoFromCustCtls = new RmacctnoFromCustCtls();
        rmacctnoFromCustCtls.setRmacctnoFromCustCtl1(inquireRmRequest.getCustomerControl1());
        rmacctnoFromCustCtls.setRmacctnoFromCustCtl3(inquireRmRequest.getCustomerControl2());
        rmacctnoFromCustCtls.setRmacctnoFromCustCtl3(inquireRmRequest.getCustomerControl3());
        rmacctnoFromCustCtls.setRmacctnoFromCustCtl4(inquireRmRequest.getCustomerControl4());
        rmacctno.setRmacctnoFromCustCtls(rmacctnoFromCustCtls);
        rmacctno.setRmacctnoFromCustNbr(inquireRmRequest.getCustomerRmNumber());
        try {
            String request = rmRequestResponseTransformer.requestTransform(rmacctno);
            //mock send request
            log.info("Sending Request URL: {} ------ REQUEST: {}", "localhost:1234/sample/request", request);
            //mock response
            String mockResponse = "   00000020751266                                                        " +
                    "00PROCESS COMPLETE                        AC05PRIIND0040000100000000000000000000201001000019687" +
                    "CP1NNNNN";
            return new InquireRmResponse().toInquireRmResponse(
                    rmRequestResponseTransformer.responseTransform(mockResponse));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ProcessException("Process Error");
        }
    }
}
