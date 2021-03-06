package war.event;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import org.springframework.format.annotation.DateTimeFormat;
import war.account.Account;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String eventName;

    @NotNull
    @Max(50)
    private Integer maxGroupSize;

    @NotNull
    private String dayOfWeek;

    @NotNull
//    @DateTimeFormat(pattern = "HH:mm")
    private String time;

    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER)
    private Set<Account> users;

}