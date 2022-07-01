//package stream;
//
//import java.io.BufferedInputStream;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.UUID;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class S3FileHandler {
//
//    private List<String> upload(MultipartHttpServletRequest request, List<Map<String, Object>> param, String imgType, Integer userId) {
//
//        log.info("upload image called");
//
//        // check if the post request has the file part
//        if (ObjectUtils.isEmpty(request.getFileMap())) {
//            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "업로드 할 이미지 파일이 없습니다");
//        }
//
//        List<MultipartFile> imgFile = request.getMultiFileMap().get("filename");
//
//        List<String> addList = param.stream().filter(m -> m.get("op").equals("A")).map(t -> String.valueOf(t.get("filename"))).collect(Collectors.toList());
//
//        List<MultipartFile> addFiles = imgFile.stream().filter(img -> addList.contains(img.getName())).collect(Collectors.toList());
//
//
////        List<String> deleteList = param.stream().filter(m -> m.get("op").equals("D")).map(t -> String.valueOf(t.get("filename"))).collect(Collectors.toList());
////        param.stream().filter(m -> m.get("op").equals("D")).map(t -> String.valueOf(t.get("filename"))).peek(k -> { // peek은 맞는 않는용도인듯. foreach일때 워닝 없음
////            AwsS3 awsS3 = AwsS3.getInstance(awsAccessKey, awsSecretKey, bucket);
////            awsS3.delete(k);
////        });
//
//        Stream<String> deleteList = param.stream().filter(m -> m.get("op").equals("D")).map(t -> String.valueOf(t.get("filename")));
//        deleteList.forEach(k -> {
//            AwsS3 awsS3 = AwsS3.getInstance(awsAccessKey, awsSecretKey, bucket);
//            awsS3.delete(imgType + "/" + k);
//        });
//        commonMapper.deleteImages(deleteList.collect(Collectors.toList()));
////
////        1. Error - 오류
////        java.lang.IllegalStateException: stream has already been operated upon or closed
////        2. Problemn - 문제
////        Stream을 두번 호출했을 때 문제가 발생한다.
////        Stream API는 한번만 호출할 수 있게 설계되어있다.
////        3. Solved - 해결
////        Stream은 매번 새로 만들어 써야한다!
////        4. Reference - 참조
////        https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
////        https://brocess.tistory.com/152
////
//
//        List<String> addList = param.stream().filter(m -> m.get("op").equals("A")).map(t -> String.valueOf(t.get("filename")+"."+"jpg")).collect(Collectors.toList());
//
//        List<ImgData> imgDataList = new ArrayList<>();
//        imgFile.stream().filter(img -> addList.contains(img.getOriginalFilename())).forEach(upfile -> {
//
//            String imageDbId = String.valueOf(UUID.randomUUID());
//            String s3FilePath = imgType + "/" + imageDbId;
//            int fileSize = (int) upfile.getSize();
//            String contentType = upfile.getContentType();
//            String filename = upfile.getOriginalFilename();
//
//            AwsS3 awsS3 = AwsS3.getInstance(awsAccessKey, awsSecretKey, bucket);
//            try (InputStream is = new BufferedInputStream(upfile.getInputStream())) {
//                awsS3.upload(is, s3FilePath, filename, contentType, fileSize);
//            } catch (Exception e) {
//                throw new BusinessException(ErrorCode.AWS0002);
//            }
//
//            imgDataList.add(new ImgData(imageDbId, imgType, filename, userId));
//
//        });
//
//        if (imgDataList.size() > 0) {
//            commonMapper.uploadImages(imgDataList);
//        }
//
////        return ImgDataList.stream().map(img -> img.getImageDbId()).collect(Collectors.toList());
//        return ImgDataList.stream().map(ImgData::getImageDbId).collect(Collectors.toList());
//
//    }
//
//}
