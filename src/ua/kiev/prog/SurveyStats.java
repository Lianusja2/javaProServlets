package ua.kiev.prog;

import java.util.HashMap;
import java.util.Map;

public class SurveyStats {

    private Map<String, Map<String, Integer>> surveyStats = new HashMap<>();

    public SurveyStats(Map<String, String> survey) {
        for (String question : survey.keySet()) {
            surveyStats.put(question, new HashMap<String, Integer>());
        }
        addSurvey(survey);
    }

    public void addSurvey(Map<String, String> survey) {
        for (String question : survey.keySet()) {
            setSurveyStats(survey, question, surveyStats.get(question));
        }
    }

    private void setSurveyStats(Map<String, String> survey, String question, Map<String, Integer> questionStat) {
        if (questionStat.containsKey(survey.get(question))) {
            int result = questionStat.get(survey.get(question)) + 1;
            questionStat.put(survey.get(question), result);
        } else {
            questionStat.put(survey.get(question), 1);
        }
        surveyStats.put(question, questionStat);
    }

    public Map<String, Map<String, Integer>> getStats() {
        Map<String, Map<String, Integer>> newSurveyStats = surveyStats;
        return newSurveyStats;
    }

    @Override
    public String toString() {
        return "SurveyStats" + surveyStats;
    }

}
