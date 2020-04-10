IMAGES="$(find . -name '*.png')"

for file in $IMAGES
do 
    img2txt -f svg -g 0.5 -d none $file > "${file%.*}.svg"
done

