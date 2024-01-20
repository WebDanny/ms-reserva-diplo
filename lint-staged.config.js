module.exports = {
  '**/*.java': (filenames) => {
    return [`./gradlew :CheckInApi:spotlessApply -Pfiles=${filenames.join(',')}`,
    `./gradlew :CheckIn.Application:spotlessApply -Pfiles=${filenames.join(',')}`,
    `./gradlew :CheckIn.Infraestructure:spotlessApply -Pfiles=${filenames.join(',')}`,
    `./gradlew :CheckInDomain:spotlessApply -Pfiles=${filenames.join(',')}`];
  },
};