package global.ntt.legstar.transformers;

import global.ntt.legstar.models.rm.input.Rmacctno;
import global.ntt.legstar.models.rm.input.bind.RmacctnoJavaToHostTransformer;
import global.ntt.legstar.models.rm.output.RmmscsrlOut;
import global.ntt.legstar.models.rm.output.bind.RmmscsrlOutHostToJavaTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Slf4j
@Component
public class RmRequestResponseTransformer {
    private static RmacctnoJavaToHostTransformer javaToHostTransformer = new RmacctnoJavaToHostTransformer();
    private static RmmscsrlOutHostToJavaTransformer hostToJavaTransformer = new RmmscsrlOutHostToJavaTransformer();
    private static final String HOST_CHARSET = "ISO-8859-15";

    public String requestTransform(Rmacctno rmacctno) throws Exception {
        log.info("start - requestTransform");
        String requestMessage = new String(javaToHostTransformer.transform(rmacctno, HOST_CHARSET), Charset.forName(HOST_CHARSET));
        log.info("end - requestTransform");
        return requestMessage;
    }

    public RmmscsrlOut responseTransform(String rmResponse) throws Exception {
        log.info("start - responseTransform");
        return hostToJavaTransformer.transform(rmResponse.getBytes(Charset.forName(HOST_CHARSET)), HOST_CHARSET);
    }
}
