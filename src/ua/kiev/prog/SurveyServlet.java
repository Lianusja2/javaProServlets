package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="SurveyServlet", value = "/survey")
public class SurveyServlet extends HttpServlet {

    private SurveyStats surveyStats;
    private Map<String, String> surveyResults = new HashMap<>();
    private String HEAD = "<html><head><title>Survey Results</title></head>";
    private String BODY = "Survey Stats<body><table class=\"tg\">%s</table></body></html>";
    private String ROW = " <tr><th>%s</th><th>%s</th></tr>";
    private String STYLE = "<style type=\"text/css\">" +
            ".tg  {border-collapse:collapse;border-spacing:0;}" +
            ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}" +
            ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}" +
            ".tg .tg-yw4l{vertical-align:top}" +
            "</style>";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        surveyResults.put("gender", request.getParameter("gender"));
        surveyResults.put("age", request.getParameter("age"));
        surveyResults.put("marital", request.getParameter("marital"));
        surveyResults.put("occupation", request.getParameter("occupation"));
        if (surveyStats == null) {
            surveyStats = new SurveyStats(surveyResults);
        } else {
            surveyStats.addSurvey(surveyResults);
        }

        Map<String, Map<String, Integer>> stats = surveyStats.getStats();
        String rowWithData = "";
        for (String key : stats.keySet()) {
            String questionStats = "";
            for (String answer : stats.get(key).keySet()) {
                questionStats += answer + ":" + stats.get(key).get(answer) + "<p>";
            }
            rowWithData += String.format(ROW, key, questionStats);
        }

        PrintWriter pw = response.getWriter();
        pw.println(HEAD);
        pw.println(STYLE);
        pw.println(String.format(BODY, rowWithData));
    }

}
