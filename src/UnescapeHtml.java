import com.mongodb.*;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * Created by aditya.dalal on 22/04/15.
 */
public class UnescapeHtml {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("sqatest");

        DBCollection coll = db.getCollection("queryAnalysis");

        DBCursor cursor = coll.find(new BasicDBObject(), new BasicDBObject("query", 1));
        long count = 0;
        while (cursor.hasNext()) {
            String query = (String)cursor.next().get("query");
            String str = query;
            for (int x = 0; x < 7; x++)
                str = StringEscapeUtils.unescapeHtml(str);
            coll.update(new BasicDBObject("query", query), new BasicDBObject("$set", new BasicDBObject("query", str)));
            count++;
            if(count%100000 == 0)
                System.out.println(count);
        }
    }
}
