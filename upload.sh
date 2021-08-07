PROJECT_PATCH="echo `pwd`"
PROGRAM_NAME="sxstudy"

jar(){
  scp $PROJECT_PATCH/sx-study-starter/target/$PROGRAM_NAME.jar melonkid@49.232.131.132:~/workspace
}

shell(){
  scp $PROJECT_PATCH/bootstrap.sh melonkid@49.232.131.132:~/workspace
}

db(){
    scp $PROJECT_PATCH/$PROGRAM_NAME.db melonkid@49.232.131.132:~/datas
}

user_exists(){
  if id -u $1 >/dev/null 2>&1; then
    echo "1"
  else
    echo "0"
  fi
}

case $1 in
        jar)
          jar
        ;;

        shell)
          shell
        ;;

        db)
          db
        ;;
        *)
      echo -e $USAGE
        ;;
esac
exit 0