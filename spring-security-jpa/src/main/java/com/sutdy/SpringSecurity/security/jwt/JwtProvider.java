package com.sutdy.SpringSecurity.security.jwt;

import com.sutdy.SpringSecurity.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtProvider {
    //공급자
    private final Key key;

    // yml에서 설정한 jwt키를 가지고오는 작업
    public JwtProvider(@Value("${jwt.secret}") String secret) { // @Value -> yml에 jwt.secret 값을 찾아옴
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
    
    public String removeBearer(String token) {
        return token.substring("Bearer ".length());
    }
    
    // 리스폰스로 해주기전에 넣어주는 단계 나중 (서비스에서 사용한다) -> 첫로그인(토큰이 없을 때 만들어준다)
    public String generateUserToken(User user) {
//                                                         1초    1분  1시간  1일  30일
        Date expireDate = new Date(new Date().getTime() + (1000L * 60 * 60 * 24 * 30));

        String token = Jwts.builder()
                .claim("userId", user.getId())
                .expiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    //나증
    public Claims parseToken(String token) { // 필터에서 문자열 삭제한 (removeBearer 메소드 동작) 토큰값으로 뭔가를 한다
        JwtParser jwtParser = Jwts.parser()
                .setSigningKey(key) // 복호화? 맞지않으면 트라이캐치문에서 잡힘 필터
//                .verifyWith()
                .build();

//        reutrn jwtParser.parseSignedContent(token).getPayload();
        return jwtParser.parseClaimsJws(token).getPayload(); // 해제된 데이터의 페이로드 가지고온다
    }
}