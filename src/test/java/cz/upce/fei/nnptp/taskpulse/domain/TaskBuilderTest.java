package cz.upce.fei.nnptp.taskpulse.domain;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

public class TaskBuilderTest {
    @Test
    void buildTaskWithDefaultValues() {
        UUID projectId = UUID.randomUUID();

        Task task = new TaskBuilder(projectId, "First Task")
                .build();

        assertThat(task.getId()).isNotNull();
        assertThat(task.getProjectId()).isEqualTo(projectId);
        assertThat(task.getTitle()).isEqualTo("First Task");
        assertThat(task.getDescription()).isEmpty();
        assertThat(task.getPriority()).isEqualTo(Priority.MEDIUM);
        assertThat(task.getState()).isEqualTo(TaskState.TODO);
        assertThat(task.getLabels()).isEmpty();
        assertThat(task.getWorklogs()).isEmpty();
    }

    @Test
    void buildTaskWithCustomValues() {
        UUID projectId = UUID.randomUUID();
        UUID taskId = UUID.randomUUID();

        Task task = new TaskBuilder(projectId, "Task Builder")
                .id(taskId)
                .description("Implement Task Builder")
                .priority(Priority.HIGH)
                .state(TaskState.IN_PROGRESS)
                .estimatedMinutes(120)
                .build();

        assertThat(task.getId()).isEqualTo(taskId);
        assertThat(task.getDescription()).isEqualTo("Implement Task Builder");
        assertThat(task.getPriority()).isEqualTo(Priority.HIGH);
        assertThat(task.getState()).isEqualTo(TaskState.IN_PROGRESS);
        assertThat(task.getEstimatedMinutes()).isEqualTo(120);
    }
}
