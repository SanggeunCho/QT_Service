-- 테이블 생성
CREATE TABLE page
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    word        VARCHAR(255) NOT NULL,
    celebration VARCHAR(255),
    summation   TEXT               NOT NULL,
    contemplation TEXT              NOT NULL,
    pray        TEXT,
    image       VARCHAR(255),
    createdAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updatedAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Mock 데이터 삽입
INSERT INTO page (word, celebration, summation, contemplation, pray)
VALUES ('여호수아 4:1-24', '63장 주가 세상을 다스리시니', '여호수아 4장 1절에서 24절 말씀에 대한 요약', '여호수아 4장 1절에서 24절 말씀에 대한 묵상 및 적용', '기도제목'),
       ('여호수아 5:1-12', '286장 주 예수님 내 맘에 오사', '여호수아 5장 1절에서 12절 말씀에 대한 요약', '여호수아 5장 1절에서 12절 말씀에 대한 묵상 및 적용', '기도제목'),
       ('여호수아 6:8-27', '312장 너 하나님께 이끌리어', '여호수아 6장 8절에서 27절 말씀에 대한 요약', '여호수아 6장 8절에서 27절 말씀에 대한 묵상 및 적용', '기도제목'),
       ('여호수아 7:1-15', '290장 우리는 주님을 늘 배반하나', '여호수아 7장 1절에서 12절 말씀에 대한 요약', '여호수아 7장 1절에서 12절 말씀에 대한 묵상 및 적용', '기도제목'),
       ('여호수아 7:16-26', '420장 너 성결키 위해', '여호수아 7장 16절에서 26절 말씀에 대한 요약', '여호수아 7장 16절에서 26절 말씀에 대한 묵상 및 적용', '기도제목');
