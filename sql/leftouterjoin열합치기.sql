SELECT * FROM study.구매정보;

SELECT 
    구매정보.구매번호,
    상품.상품명,
    사이즈.사이즈명,
    색상.색상명,
    상태.상태명,
    구매자.구매자이름,
    성별.성별
FROM
    구매정보
LEFT OUTER JOIN 상품 on (상품.상품번호 = 구매정보.상품번호)
LEFT OUTER JOIN 사이즈 on (사이즈.사이즈번호 = 상품.사이즈번호)
LEFT OUTER JOIN 색상 on ( 색상.색상번호 = 상품.색상번호)
LEFT OUTER JOIN 상태 on (상태.상태번호 = 구매정보.상태번호)
LEFT OUTER JOIN 구매자 on (구매자.구매자번호 = 구매정보.구매자번호)
LEFT OUTER JOIN 성별 on (성별.성별번호 = 구매자.성별)

/*
	마스터테이블에는 다른 테이블들과 매칭시켜줄 수 있는 기준을 부여(id)해주고 원하는 컬럼을 호출
    FROM → LEFT OUTER JOIN 가상의 컬럼을 불러오고 클라이언트에게 보여줌
    순서
    FROM - SELECT
*/