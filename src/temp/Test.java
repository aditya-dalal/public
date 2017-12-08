package temp;


import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by aditya.dalal on 24/12/16.
 */
public class Test {

    public static void main(String[] args) {

        String str = "data:text/html,chromewebdata";
        System.out.println(getDomain(str));
        System.out.println(getDomain1(str));

    }

    public static String getDomain1(String documentUri) {
        String str = documentUri;
        if(documentUri.contains("://")) {
            URI uri;
            try {
                uri = new URI(documentUri);
                str = uri.getAuthority();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    private static String getDomain(String documentUri) {
        int index = documentUri.indexOf("://");
        if(index != -1) {
            documentUri = documentUri.substring(index + 3);
            index = documentUri.indexOf("/");
            if (index != -1)
                documentUri = documentUri.substring(0, index);
        }
        return documentUri;
    }
}
