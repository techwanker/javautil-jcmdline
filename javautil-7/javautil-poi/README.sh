mkdir -p target/tmp
m4 README.m4 > README.md
pandoc README.md -o README.html

