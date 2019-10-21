adb shell 'am startservice -a com.aranteknoloji.PUSH_NOTIFICATION --es text "'$@'"'
echo $@
echo '--es text "'$@'"'
#adb shell 'am startservice -a com.aranteknoloji.PUSH_NOTIFICATION --es text "Here is the Push Notification"'
#adb shell am startservice -a com.aranteknoloji.PUSH_NOTIFICATION -e 'text' "Here' 'is' 'the' 'definition' 'of' 'kind' 'of' 'SUCCESS"
