const fs = require('fs');

const rs = fs.createReadStream('./readMe.txt', 'utf-8');

rs.on('data', (chunk) => {
  console.log('new chunk load: ');
  console.log(chunk.length, chunk);
})
  .on('end', () => {
    console.log('chunk load is finished!');
  })
  .on('error', (err) => {
    console.error(err);
  });

// 스트림과 파이프를 이용해서 writeMe.txt로 복사하기
const ws = fs.createWriteStream('./writeMe.txt', 'utf-8');

rs.pipe(ws);
