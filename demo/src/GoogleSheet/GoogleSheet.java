package GoogleSheet;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.*;
import java.util.*;

/**
 * From
 * https://developers.google.com/sheets/api/quickstart/java
 * More:
 * https://developers.google.com/sheets/api/guides/values
 * API Explorer (Demo with Forms)
 * https://developers.google.com/apis-explorer/#p/sheets/v4/
 */
public class GoogleSheet {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME =
            "Google Sheets Demo";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     * <p>
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in = new FileInputStream("./res/GoogleSheet/client_id.json");
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     *
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();

        // Prints the names and majors of students in a sample spreadsheet:
        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        String spreadsheetId = "1NkR1AUmIu0g7QWJDKQ8gzGSCWD7R27SH-ljkYq_taaw";
        String range = "2012!A1:Y42"; // SheetName!Range
//        Here are a few examples that demonstrate the range syntax:
//        A1:B10 - A range from cell A1 through B10
//        5:7 - Rows 5-7
//        D:F - Columns D-F
//        A:A70 - The first 70 cells in column A
//        A70:A - Column A from row 70 to the end
//        B5:5 - B5 to the end of row 5
//        D3:D - D3 to the end of column D
//        C:C10 - From the beginning of column C to C10
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> rows = response.getValues();
        if (rows == null || rows.size() == 0) {
            System.out.println("No data found.");
        } else {

            // Processing variable
            Map<Integer, Object> periods = new HashMap<>();
            Map<Integer, Object> users = new HashMap<>();
            Map<Integer, Map<Integer, Double>> expenses = new HashMap<>();
            Map<Integer, String> expensesDesc = new HashMap<>();

            for (int j = 0; j < rows.size(); j++) {

                switch (j) {
                    case 0:
                        System.out.printf("%s\t", j);
                        System.out.println("Skipped");
                        break;
                    case 1: {
                        System.out.printf("%s\t", j);
                        List<Object> row = rows.get(j);
                        Object currentPeriod = null;
                        // Print columns A and E, which correspond to indices 0 and 4.
                        for (int i = 0; i < row.size(); i++) {
                            Object val = row.get(i);

                            if (val != null && (!val.equals(""))) {
                                currentPeriod = val;
                            }
                            if (currentPeriod != null) {
                                periods.put(i, currentPeriod);
                            }
                        }

                        System.out.println(periods.toString());
                        break;
                    }
                    case 2: {
                        System.out.printf("%s\t", j);
                        List<Object> row = rows.get(j);
                        Object currentUser = null;
                        // Print columns A and E, which correspond to indices 0 and 4.
                        for (int i = 0; i < row.size(); i++) {
                            Object val = row.get(i);

                            if (val != null && (!val.equals(""))) {
                                currentUser = val;
                            }
                            if (currentUser != null) {
                                users.put(i, currentUser);
                            }
                        }

                        System.out.println(users.toString());
                        break;
                    }
                    default: {
                        List<Object> row = rows.get(j);
                        if (row.size()>0) {
                            expensesDesc.put(j, (String) row.get(0));
                            Map<Integer, Double> expensesAmount = new HashMap<>();
                            // Print columns A and E, which correspond to indices 0 and 4.
                            for (int i = 1; i < row.size(); i++) {
                                String val = (String) row.get(i);

                                if (val != null && (!val.equals(""))) {
                                    try {
                                        expensesAmount.put(i, Double.valueOf(val));
                                    } catch (Exception e) {
                                        System.err.println("Error: Val (" + val + "), Coordinates (" + j + "," + i + ")");
                                        e.printStackTrace();
                                    }
                                }

                            }
                            expenses.put(j, expensesAmount);
                        }
                        break;
                    }
                }
            }

            List<List<Object>> ledger = new ArrayList<>();

            for(Map.Entry<Integer, Map<Integer, Double>>  expenseByLine: expenses.entrySet()){
                Integer lineNumber = expenseByLine.getKey();
                Map<Integer,Double> expensesAmount = expenseByLine.getValue();
                for (Map.Entry<Integer,Double> expense: expensesAmount.entrySet()){
                    Integer columnNumber = expense.getKey();
                    Double expenseAmount = expense.getValue();
                    List<Object> legerRow = Arrays.asList(new Object[]{periods.get(columnNumber), users.get(columnNumber), expensesDesc.get(lineNumber), expenseAmount});
                    ledger.add(legerRow);
                }
            }

            System.out.println(ledger);

        }
    }


}