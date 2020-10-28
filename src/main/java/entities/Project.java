package entities;

import lombok.*;

import javax.persistence.*;

@Entity // represent a table in db
@Table(name = "project")
@Data // generate getter and setter behind
@NoArgsConstructor // generate default ctor that takes no args
@AllArgsConstructor // generate ctor that takes all props
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_code", unique = true)
    private String projectCode;

    @Column(name = "project_name", length = 1000)
    private String projectName;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;
}
