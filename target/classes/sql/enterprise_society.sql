
CREATE TABLE enterprise (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    enterprise_name VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(20),
    address VARCHAR(255),
    description TEXT,
    image_url TEXT,
    manager VARCHAR(255),
    manager_contact_phone VARCHAR(20),
    status INT NOT NULL DEFAULT 1,
    remark TEXT,
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 如果需要其他相关的表，可以在这里继续添加
