CREATE TABLE article (
  id SERIAL PRIMARY KEY,
  wp_internal_id BIGINT NOT NULL,
  wp_published_time TIMESTAMP NOT NULL,
  title VARCHAR(110) NOT NULL,
  slug VARCHAR(110) NOT NULL
);

CREATE TABLE post (
  id SERIAL PRIMARY KEY,
  fb_internal_id VARCHAR(35) NOT NULL,
  fb_published_date TIMESTAMP NOT NULL,
  fb_title VARCHAR(120) NOT NULL,
  fb_link VARCHAR(150) NOT NULL,
  fb_description VARCHAR(500),
  likes INT NOT NULL,
  shares INT NOT NULL,
  comments INT NOT NULL,
  consumptions INT NOT NULL
);