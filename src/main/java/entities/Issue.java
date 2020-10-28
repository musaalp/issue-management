package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity // represent a table in db
@Table(name = "issue")
@Data // generate getter and setter behind
@NoArgsConstructor // generate default ctor that takes no args
@AllArgsConstructor // generate ctor that takes all props
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {

    @Id // primary pk
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "details", length = 4000)
    private String details;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issue_status")
    @Enumerated(EnumType.STRING)
    private IssueStatus issueStatus;

    // many issue can assign to one user, FetchType.LAZY: makes inner join to user entity when getter calls
    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
}
