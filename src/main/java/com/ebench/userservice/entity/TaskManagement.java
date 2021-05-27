package com.ebench.userservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "task_managemnet")
public class TaskManagement extends BaseEntity {
    @Column(name = "completed_task")
    public String completedTask;

    @Column(name = "ongoing_task")
    public String ongoingTask;

    @Column(name = "cancelled_task")
    public String cancelledTask;

    @Column(name = "over_due_task")
    public String overdueTask;

    @Column(name = "coming_up_task")
    public String comingupTask;

    @Column(name = "task_request")
    public String taskRequest;
}
