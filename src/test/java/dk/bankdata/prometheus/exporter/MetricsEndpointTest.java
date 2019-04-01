package dk.bankdata.prometheus.exporter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.prometheus.client.hotspot.DefaultExports;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import org.junit.jupiter.api.Test;

public class MetricsEndpointTest {

    MetricsEndpoint endpoint = new MetricsEndpoint();

    @Test
    public void testMetrics() throws IOException {
        DefaultExports.initialize();
        Response response = endpoint.metrics();
        StreamingOutput out = (StreamingOutput) response.getEntity();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        out.write(baos);
        assertTrue(baos.size() > 1000);
    }

}
