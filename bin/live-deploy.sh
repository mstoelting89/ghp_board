#!/bin/bash

echo "*****************************"
echo "***** Start Live Deploy *****"
echo "*****************************"

echo "***** Backup database *****"
ssh raspi "cd /home/pi/ghp_board && docker-compose exec -T db /bin/bash -c 'mysqldump -u root -p83MoHHStuRgfSxSXc66w7tjm35 --all-databases > /ghp_board_backup.sql'"
ssh raspi "docker cp ghp_board_db_1:/ghp_board_backup.sql /home/pi/ghp_board/ghp_board_backup.sql"
echo "***** Backup Datenbank successful *****"

echo "***** Build Jar *****"
cd /home/michael/Projekte/private/ghp_board/backend/system/ && ./gradlew build
echo "***** Build Jar successful *****"

echo "***** Upload jar to server *****"
scp /home/michael/Projekte/private/ghp_board/backend/system/build/libs/system-0.0.1-SNAPSHOT.jar raspi:/home/pi/ghp_board/ghp_board_backend/
echo "***** Upload jar to server successful *****"

echo "***** Build and Restart Docker *****"
ssh raspi "cd /home/pi/ghp_board && docker-compose down && docker-compose build && docker-compose up -d"
echo "***** Build and Restart Docker successful *****"

echo "***** Import database *****"
sleep 20
ssh raspi "docker cp /home/pi/ghp_board/ghp_board_backup.sql ghp_board_db_1:/ghp_board_backup.sql"
ssh raspi "cd /home/pi/ghp_board && docker-compose exec -T db /bin/bash -c 'mysql -u root -p83MoHHStuRgfSxSXc66w7tjm35 </ghp_board_backup.sql'"
ssh raspi "cd /home/pi/ghp_board && docker-compose exec -T db /bin/bash -c 'rm -f ghp_board_backup.sql'"
echo "***** Import database successful *****"

echo "***** build frontend *****"
cd /home/michael/Projekte/private/ghp_board/frontend/ && npm run build
ssh ionos-vps "cd /var/www/html && rm -rf dist_old && mv dist dist_old"
scp -r /home/michael/Projekte/private/ghp_board/frontend/dist ionos-vps:/var/www/html/
echo "***** build frontend successful *****"