import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by gondals on 16/10/16.
 */
public class OutOfDateServersTest {

    @Test
    public void testOutOfServer() throws Exception {
        MyReader myReader = new MyReader();
        myReader.setData("Server1", "Database", "MySQL", "5", "5");
        myReader.setData("Server2", "Database", "MySQL", "5", "1");
        myReader.setEmpty();


        OutOfDateServers outOfDateServers = new OutOfDateServers(myReader);
        outOfDateServers.execute();
        Set<String> outOfDateServer = outOfDateServers.getOutOfDateServer();
        Assert.assertTrue(outOfDateServer.size() == 1);
        Assert.assertTrue(outOfDateServer.contains("Server2"));
    }

    public static class MyReader extends OutOfDateServers.Reader {
        private int count = 0;
        private List<OutOfDateServers.Data> datas = new ArrayList<>();

        @Override
        public OutOfDateServers.Data getData() throws IOException {
            return datas.get(count++);
        }

        public void setData(final String server, final String software1, final String software2, final String v1, String v2) {
            List<String> versions = new ArrayList<>();
            versions.add(v1);
            versions.add(v2);
            datas.add(new OutOfDateServers.Data(server, software1, software2, versions));
        }

        public void setEmpty() {
            datas.add(null);
        }
    }
}
