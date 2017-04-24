import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by gondals on 16/10/16.
 */
public class OutOfDateServers {
    private Map<Pair<String, String>, List<String>> softwareVersion = new HashMap<>();
    private Map<Pair<String, String>, List<String>> softwareVersionServers = new HashMap<>();
    private Set<String> outOfDateServer = new HashSet<>();
    private Reader reader;

    public OutOfDateServers(final Reader reader) throws FileNotFoundException, URISyntaxException {
        this.reader = reader;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        new OutOfDateServers(new Reader("input.txt")).execute();
    }

    public void execute() throws IOException, URISyntaxException {
        Data data = reader.getData();
        while(data != null) {
            checkSoftwareVersion(data);
            data = reader.getData();
        }
        System.out.println(outOfDateServer);
    }

    private void checkSoftwareVersion(final Data data) {
        Pair<String, String> pair = data.getPair();
        List<String> newVersion = data.version;
        List<String> existingVersion = softwareVersion.get(pair);

        if (existingVersion == null) {
            updateSoftwareVersion(pair, newVersion);
            updateSoftwareVersionServerList(pair, data.server);
        }
        else {
            if (isNewVersionLatest(newVersion, existingVersion)) {
                updateSoftwareVersion(pair, newVersion);
                updateOutOfDateServer(pair);
                updateSoftwareVersionServerList(pair, data.server);
            } else if (isNewVersionDifferent(newVersion, existingVersion)) {
                outOfDateServer.add(data.server);
            }
        }
    }

    private void updateOutOfDateServer(final Pair<String, String> pair) {
        outOfDateServer.addAll(softwareVersionServers.get(pair));
    }

    private void updateSoftwareVersionServerList(final Pair<String, String> pair, final String server) {
        List<String> servers = new ArrayList<>();
        servers.add(server);
        softwareVersionServers.put(pair, servers);
    }

    private void updateSoftwareVersion(final Pair<String, String> pair, final List<String> newVersion) {
        softwareVersion.put(pair, newVersion);
    }

    private boolean isNewVersionDifferent(final List<String> newVersion, final List<String> existingVersion) {
        for (int i = 0; i < newVersion.size(); i++) {
            String newV = newVersion.get(i);
            String oldV = existingVersion.get(i);
            if (Integer.valueOf(newV) != Integer.valueOf(oldV))
                return true;
        }
        return false;
    }

    private boolean isNewVersionLatest(final List<String> newVersion, final List<String> existingVersion) {
        for (int i = 0; i < newVersion.size(); i++) {
            String newV = newVersion.get(i);
            String oldV = existingVersion.get(i);
            if (Integer.valueOf(newV) > Integer.valueOf(oldV))
                return true;
        }
        return false;
    }

    private static Data parseLine(final String line) {
        if (line == null)
            return null;
        String[] tokens = line.split(",");
        String server = tokens[0].trim();
        String software1 = tokens[1].trim();
        String software2 = tokens[2].trim();
        List<String> version = new ArrayList<>();
        String[] versionTokens = tokens[3].trim().split("\\.");
        for (int i = 0; i < versionTokens.length; i++) {
            version.add(versionTokens[i]);
        }
        return new Data(server, software1, software2, version);
    }

    private BufferedReader getFileReader(final String fileName) throws URISyntaxException, FileNotFoundException {
        URL path = ClassLoader.getSystemResource(fileName);
        if (path == null)
            throw new FileNotFoundException("Could not find file " + fileName);
        File f = new File(path.toURI());
        return new BufferedReader(new FileReader(f));
    }

    public static class Reader {
        private String fileName;
        private BufferedReader bufferedReader;

        public Reader() {
        }

        public Reader(final String fileName) throws FileNotFoundException, URISyntaxException {
            this.fileName = fileName;

            URL path = ClassLoader.getSystemResource(fileName);
            if (path == null)
                throw new FileNotFoundException("Could not find file " + fileName);
            File f = new File(path.toURI());
            bufferedReader = new BufferedReader(new FileReader(f));
        }

        public Data getData() throws IOException {
            String line = bufferedReader.readLine();
            return parseLine(line);
        }
    }

    public static class Data {
        private String server;
        private String software1;
        private String software2;
        private List<String> version;


        public Data(final String server, final String software1, final String software2, final List<String> version) {
            this.server = server;
            this.software1 = software1;
            this.software2 = software2;
            this.version = version;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "server='" + server + '\'' +
                    ", software1='" + software1 + '\'' +
                    ", software2='" + software2 + '\'' +
                    ", version=" + version +
                    '}';
        }

        public Pair getPair() {
            return new Pair<>(software1, software2);
        }
    }

    private static class Pair<L,R> {

        private final L left;
        private final R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() { return left; }
        public R getRight() { return right; }

        @Override
        public int hashCode() { return left.hashCode() ^ right.hashCode(); }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair pairo = (Pair) o;
            return this.left.equals(pairo.getLeft()) &&
                    this.right.equals(pairo.getRight());
        }

    }

    public Map<Pair<String, String>, List<String>> getSoftwareVersion() {
        return softwareVersion;
    }

    public Map<Pair<String, String>, List<String>> getSoftwareVersionServers() {
        return softwareVersionServers;
    }

    public Set<String> getOutOfDateServer() {
        return outOfDateServer;
    }

}
