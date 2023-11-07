package applications.github.api.user_module.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Plan {
   String name;
   int space;
   int private_repos;
   int collaborators;
}
