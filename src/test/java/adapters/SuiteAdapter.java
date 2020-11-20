package adapters;

import models.TestSuite;

public class SuiteAdapter extends BaseAdapter{
   public static final String URI = "v1/suite";

    public int create(String projectCode, TestSuite testSuite) {
        return post(String.format("%s/%s", URI, projectCode), converter.toJson(testSuite))
                .body().path("result.id");
    }

    public void delete(String projectCode, int id) {
        delete(String.format("%s/%s/%s", URI, projectCode, id));
    }
}
