package cz.upce.fei.nnptp.taskpulse.domain;

import java.time.LocalDate;
import java.util.*;

public class TaskBuilder {
    private UUID id;
    private final UUID projectId;
    private final String title ;
    private String description = "";
    private Priority priority = Priority.MEDIUM;
    private TaskState state = TaskState.TODO;
    private Integer estimatedMinutes;
    private LocalDate dueDate;
    private  Set<String> labels = new LinkedHashSet<>();
    private  List<Worklog> worklogs = new ArrayList<>();

    /**
     *
     * @param projectId
     * @param title
     */
    public TaskBuilder(UUID projectId, String title){
        this.id = UUID.randomUUID();
        this.projectId = projectId;
        this.title = title;
    }

    public TaskBuilder id(UUID id){
        this.id = id;
        return this;
    }

    public TaskBuilder description(String description){
        this.description = description;
        return this;
    }

    public TaskBuilder priority(Priority priority){
        this.priority = priority;
        return this;
    }

    public TaskBuilder state(TaskState state){
        this.state = state;
        return this;
    }

    public TaskBuilder estimatedMinutes(Integer estimatedMinutes){
        this.estimatedMinutes = estimatedMinutes;
        return this;
    }

    public TaskBuilder labels(Collection<String> labels) {
        this.labels = labels == null
                ? new LinkedHashSet<>()
                : new LinkedHashSet<>(labels);
        return this;
    }

    public TaskBuilder worklogs(Collection<Worklog> worklogs) {
        this.worklogs = worklogs == null
                ? new ArrayList<>()
                : new ArrayList<>(worklogs);
        return this;
    }

    public TaskBuilder dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     *
     */
    public Task build(){
        return new Task(
                id,
                projectId,
                title,
                description,
                priority,
                state,
                estimatedMinutes,
                dueDate,
                labels,
                worklogs
        );
    }
}
