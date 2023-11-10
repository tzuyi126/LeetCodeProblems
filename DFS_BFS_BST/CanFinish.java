// 207. Course Schedule
// https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // There should be no cycle in the graph.

        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }

            adj[prerequisite].add(course);
            indegree[course]++;
        }

        // q: courses can be taken
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // Courses without prerequisites
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topology = new ArrayList<>();
        while (!q.isEmpty()) {
            int takenCourse = q.poll();
            topology.add(takenCourse);

            if (adj[takenCourse] != null) {
                for (int nextCourse: adj[takenCourse]) {
                    indegree[nextCourse]--;

                    // Satisfied all prerequisites for nextCourse
                    if (indegree[nextCourse] == 0) {
                        q.add(nextCourse);
                    }
                }
            }
        }

        return topology.size() == numCourses;
    }
}
