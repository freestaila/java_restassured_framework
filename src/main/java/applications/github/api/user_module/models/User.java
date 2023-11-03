package applications.github.api.user_module.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class User {
    String login;
    int id;
    String node_id;
    String avatar_url;
    String gravatar_id;
    String url;
    String html_url;
    String followers_url;
    String following_url;
    String gists_url;
    String starred_url;
    String subscriptions_url;
    String organizations_url;
    String repos_url;
    String events_url;
    String received_events_url;
    String type;
    boolean site_admin;
    String name;
    String company;
    String blog;
    String location;
    String email;
    boolean hireable;
    String bio;
    String twitter_username;
    int public_repos;
    int public_gists;
    int followers;
    int following;
    String created_at;
    String updated_at;
}
