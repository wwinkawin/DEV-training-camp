package devbootcamp.miniboss.demo.model.catFacts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cat implements Comparable<Cat>{
    private Long id;

    @NotEmpty(message = "Please provide cat id")
    private String _id;

    @NotEmpty(message = "Please provide a text")
    private String text;

    //Use Access.WRITE_ONLY if don't want to return this field in response
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer upvotes;

    @Override
    public int compareTo(Cat o) {
        return getUpvotes().compareTo(o.getUpvotes());
    }
}