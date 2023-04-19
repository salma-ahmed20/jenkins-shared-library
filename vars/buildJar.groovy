def call (){
    echo "building the application from shared lib $BRANCH_NAME..."
    sh 'mvn clean package'
}
