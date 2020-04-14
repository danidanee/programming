<h1>Git 명령어 관리</h1>

<br/>

1. 저장소 생성

```
git init
```

<br/>

2. 원격 저장소 가져오기

```
git remote add [origin] [https://github.com/danidanee/programming.git]
```

<br/>

3. 저장소 확인

```
git remote -v
```

<br/>

4. 원격 저장소 복사

```
git clone [https://github.com/danidanee/programming.git]
```

<br/>

5. 원격 저장소의 특정 브랜치로 바꾸기

```
git checkout -t [origin/dev-front]
→ git pull [origin] [dev-front]
```

<br/>

6. 브랜치 생성

```
git checkout -b [feature/login]
```

<br/>

7. 브랜치 삭제

```
git branch -D [feature/login]
```

<br/>

8. 병합

```
git merge [feature/login]
```

<br/>

9. 가져오기

```
git pull [origin] [master]
```

<br/>

10. 보내기

```
git push [origin] [master]
```

<br/>

11. 기타 명령어

```
git add .
git commit -m "설명설명"
```

<br/><br/>

참고 사이트 : https://backlog.com/git-tutorial/kr/stepup/stepup6_1.html

<br/>

------

[], "" : 변경해서 작성 가능한 부분, [] 는 제외하고 입력

