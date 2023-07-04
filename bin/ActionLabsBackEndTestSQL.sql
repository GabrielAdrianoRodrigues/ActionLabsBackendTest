/*
    I am having a little trouble finding the best candidate based on test results.
    For each answered question I decided for a score (0, 0.5 or 1.0).
    I have three tables in the database: candidate, test and question_score.
    The candidate table has two columns: candidate_id and name. The test table has
    2 columns: test_id and name. The question_score table has 4 columns: question_id,
    candidate_id, test_id and score, with candidate_id being a FK to the candidate table
    and test_id is a FK to the test table. I need a SQL query that return the candidate
    name and his total score, ordered by the best candidate (bigger score) to the worst,
    for all candidates that answered the test named "Java backend".
    Tables: candidate(candidate_id, name), test(test_id, name), 
    question_score(question_id, candidate_id, test_id, score)
*/
SELECT  c.name        AS candidate_name,
        SUM(qs.score) AS candidate_score
FROM test t
    INNER JOIN question_score qs
        ON qs.test_id = t.id
    INNER JOIN candidate c
        ON c.id = qs.candidate_id
WHERE t.name = 'Java backend'
GROUP BY c.name
ORDER BY SUM(qs.score) DESC;
